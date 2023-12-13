package pt.isec.pd.eventsManager.api.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("events")
public class EventsController {

    // Handle GET request for all events
    @GetMapping
    public String getAllEvents(Authentication authentication,
        // Logic to get information about all events
        return "All events information";
    }

    // Handle GET request for a specific event by ID
    @GetMapping("/{id}")
    public String getEventById(@PathVariable Long id) {
        // Logic to get information about the event with the specified ID
        return "Event information for ID " + id;
    }

    private ResponseEntity generateMessage(String type, Integer length, String prefix) {

        Lorem lorem = LoremIpsum.getInstance();
        String text = switch (type) {
            case "word" -> lorem.getWords(length);
            case "sentence" -> lorem.getSentences(length);
            case "paragraph" -> lorem.getParagraphs(length);
            default -> "Invalid type";
        };
        if (prefix != null)
            text = prefix + " " + text;
        return ResponseEntity.ok(text);
    }
}