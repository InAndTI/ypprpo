package nsu.ypprpo.peoples_world.controllers;

import nsu.ypprpo.peoples_world.models.SocialNetwork;
import nsu.ypprpo.peoples_world.services.SocialNetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/social_networks")
public class SocialNetworkController {

    @Autowired
    private SocialNetworkService socialNetworkService;

    @GetMapping
    public ResponseEntity<List<SocialNetwork>> getAllSocialNetworks() {
        List<SocialNetwork> socialNetworks = socialNetworkService.getAllSocialNetworks();
        return ResponseEntity.ok(socialNetworks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SocialNetwork> getSocialNetworkById(@PathVariable("id") Integer id) {
        SocialNetwork socialNetwork = socialNetworkService.getSocialNetworkById(id);
        return ResponseEntity.ok(socialNetwork);
    }

    @PostMapping
    public ResponseEntity<SocialNetwork> createSocialNetwork(@RequestBody SocialNetwork socialNetwork) {
        SocialNetwork createdSocialNetwork = socialNetworkService.createSocialNetwork(socialNetwork);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSocialNetwork);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SocialNetwork> updateSocialNetwork(@PathVariable("id") Integer id, @RequestBody SocialNetwork socialNetwork) {
        SocialNetwork updatedSocialNetwork = socialNetworkService.updateSocialNetwork(id, socialNetwork);
        return ResponseEntity.ok(updatedSocialNetwork);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSocialNetwork(@PathVariable("id") Integer id) {
        socialNetworkService.deleteSocialNetwork(id);
        return ResponseEntity.noContent().build();
    }
}
