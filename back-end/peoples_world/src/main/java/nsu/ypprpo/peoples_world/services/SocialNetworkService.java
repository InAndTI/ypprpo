package nsu.ypprpo.peoples_world.services;

import nsu.ypprpo.peoples_world.models.SocialNetwork;
import nsu.ypprpo.peoples_world.repository.SocialNetworksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocialNetworkService {

    @Autowired
    private SocialNetworksRepository socialNetworkRepository;

    public List<SocialNetwork> getAllSocialNetworks() {
        return socialNetworkRepository.findAll();
    }

    public SocialNetwork getSocialNetworkById(Integer id) {
        Optional<SocialNetwork> socialNetworkOptional = socialNetworkRepository.findById(id);
        return socialNetworkOptional.orElse(null);
    }

    public SocialNetwork createSocialNetwork(SocialNetwork socialNetwork) {
        return socialNetworkRepository.save(socialNetwork);
    }

    public SocialNetwork updateSocialNetwork(Integer id, SocialNetwork updatedSocialNetwork) {
        Optional<SocialNetwork> socialNetworkOptional = socialNetworkRepository.findById(id);
        if (socialNetworkOptional.isPresent()) {
            updatedSocialNetwork.setSocial_id(id);
            return socialNetworkRepository.save(updatedSocialNetwork);
        } else {
            return null;
        }
    }

    public void deleteSocialNetwork(Integer id) {
        socialNetworkRepository.deleteById(id);
    }
}
