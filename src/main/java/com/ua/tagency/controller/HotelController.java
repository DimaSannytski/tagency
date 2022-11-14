package com.ua.tagency.controller;

import com.ua.tagency.dto.*;
import com.ua.tagency.service.CountryService;
import com.ua.tagency.service.HotelService;
import javax.validation.Valid;

import com.ua.tagency.service.PersonService;
import com.ua.tagency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreInvocationAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class HotelController {

    private final HotelService hotelService;
    private final CountryService countryService;
    private final RoomService roomService;
    private final PersonService personService;

    @Autowired
    public HotelController(HotelService hotelService, CountryService countryService, RoomService roomService, PersonService personService) {
        this.hotelService = hotelService;
        this.countryService = countryService;
        this.roomService = roomService;
        this.personService = personService;
    }

    @GetMapping({"/hotels", "/"})
    public String showHotels(Model model, Principal principal) {
        model.addAttribute("hotels", hotelService.getHotels());
        model.addAttribute("userDet", personService.getPersonDetails(principal));
        return "hotels";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("hotels/create")
    public String createHotelPage(Model model) {
        model.addAttribute("hotelModel", new CreateHotelDto());
        model.addAttribute("countries", countryService.getCountries());
        return "create_hotel";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("hotels/{hotelId}/rooms/create")
    public String createRoomsPage(@PathVariable Integer hotelId, Model model) {
        model.addAttribute("createRoomsModel", new CreateRoomsDto(hotelId));
        return "create_rooms";
    }

    @GetMapping("/hotels/{hotelId}")
    public String hotelPage(@PathVariable Integer hotelId, Model model, Principal principal) {
        model.addAttribute("hotelModel", hotelService.getHotelPage(hotelId));
        model.addAttribute("userDet", personService.getPersonDetails(principal));
        return "hotel";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("hotels/{hotelId}/create_room")
    public String createRoom(@PathVariable Integer hotelId, Model model) {
        model.addAttribute("roomModel", new BaseRoomDto());
        return "create_room";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("room/{roomId}/edit")
    public String editRoom(@PathVariable Integer roomId, Model model) {
        model.addAttribute("roomModel", roomService.getRoomForEdit(roomId));
        return "edit_room";
    }

    @GetMapping("room/{roomId}")
    public String roomPage(@PathVariable Integer roomId, Model model, Principal principal) {
        model.addAttribute("roomModel", roomService.getRoomForPage(roomId));
        model.addAttribute("reservedDates", roomService.getReservedDates(roomId));
        model.addAttribute("orderModel", new CreateOrderDto(roomId,
                personService.getPersonIdFromPrincipal(principal)));
        model.addAttribute("userDet", personService.getPersonDetails(principal));
        return "room";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("hotels/{hotelId}/edit")
    public String editHotel(@PathVariable Integer hotelId, Model model) {
        model.addAttribute("hotelModel", hotelService.getEditDto(hotelId));
        model.addAttribute("countries", countryService.getCountries());
        return "edit_hotel";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("hotels/edit")
    public String editHotel(@ModelAttribute("hotelModel") @Valid EditHotelDto hotelDto) {
        hotelService.updateHotel(hotelDto);
        return "redirect:/hotels/" + hotelDto.getId();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("hotels/create")
    public String addHotel(@ModelAttribute("hotelModel") @Valid CreateHotelDto hotelDto, BindingResult result) {
        if (result.hasErrors()) return "create_hotel";
        hotelService.createHotel(hotelDto);
        return "redirect:/hotels";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("hotels/delete")
    public String deleteHotel(@RequestParam Integer id) {
        hotelService.deleteById(id);
        return "redirect:/hotels";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("hotels/rooms/create")
    public String createRooms(@ModelAttribute("createRoomsModel") @Valid CreateRoomsDto createRoomsDto,
                              BindingResult result) {
        hotelService.createRooms(createRoomsDto);
        return "redirect:/hotels/" + createRoomsDto.getHotelId();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("hotels/rooms/delete")
    public String deleteRoom(@RequestParam Integer id, @RequestParam Integer hotelId) {
        roomService.deleteById(id);
        return "redirect:/hotels/" + hotelId;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("room/create")
    public String createRoom(@ModelAttribute("roomModel")BaseRoomDto dto) {
        roomService.createRoom(dto);
        return  "redirect:/hotels/" + dto.getHotelId();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("room/edit")
    public String updateRoom(@ModelAttribute("roomModel") BaseRoomDto dto) {
        roomService.updateRoom(dto);
        return  "redirect:/hotels/" + dto.getHotelId();
    }
}
