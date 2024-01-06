package MarcoWalter.AideAuxVulnerableRelation.controller;

import MarcoWalter.AideAuxVulnerableRelation.model.InfosMission;
import MarcoWalter.AideAuxVulnerableRelation.model.InfosPersonne;
import MarcoWalter.AideAuxVulnerableRelation.model.Mission;
import MarcoWalter.AideAuxVulnerableRelation.model.Personne;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RelationSpringService {
	
	@Autowired
	private RestTemplate restTemplate;

    @GetMapping("/infosPersonne/{personneId}")
    public InfosPersonne infosPersonne(@PathVariable int personneId) {
        Personne personne = restTemplate.getForObject("http://aideAuxVulnerablePersonne/getPersonne/" + personneId,
                Personne.class);

        if (personne.getRole().getValue() == "Demandeur") {
            ResponseEntity<Collection<Mission>> missionsResponse = restTemplate.exchange(
                    "http://aideAuxVulnerableMission/getMissionsDemandeur/" + personne.getId(),
                    HttpMethod.GET, null, new ParameterizedTypeReference<Collection<Mission>>() {
                    });
            Collection<Mission> collection = missionsResponse.getBody();
            return new InfosPersonne(personne.getId(), personne.getNom(), personne.getPrenom(), personne.getAge(),
                    personne.getAdresse(), personne.getIsReferentNeeded(), collection);
        } else if (personne.getRole().getValue() == "Benevole") {
            ResponseEntity<Collection<Mission>> missionsResponse = restTemplate.exchange(
                    "http://aideAuxVulnerableMission/getMissionsBenevole/" + personne.getId(),
                    HttpMethod.GET, null, new ParameterizedTypeReference<Collection<Mission>>() {
                    });
            Collection<Mission> collection = missionsResponse.getBody();
            return new InfosPersonne(personne.getId(), personne.getNom(), personne.getPrenom(), personne.getAge(),
                    personne.getAdresse(), personne.getIsReferentNeeded(), collection);
        } else {
            return new InfosPersonne(personne.getId(), personne.getNom(), personne.getPrenom(), personne.getAge(),
                    personne.getAdresse(), null, null);
        }
    }

    @GetMapping("/infosMission/{missionId}")
    public InfosMission infosMission(@PathVariable int missionId) {
        Mission mission = restTemplate.getForObject("http://aideAuxVulnerableMission/getMission/" + missionId,
                Mission.class);

        Personne demandeur = restTemplate
                .getForObject("http://aideAuxVulnerablePersonne/getPersonne/" + mission.getDemandeurId(), Personne.class);
        Personne benevole = restTemplate.getForObject(
                "http://aideAuxVulnerablePersonne/getPersonne/" + mission.getBenevoleAssigneId(), Personne.class);

        if (benevole == null) {
            return new InfosMission(mission.getId(), mission.getDemandeurId(),
                    mission.getBenevoleAssigneId(),
                    mission.getSujet(), mission.getMotif(), mission.getAvis(), mission.isValidated(),
                    mission.isWaiting(),
                    mission.isRealised(), mission.isReferred(), mission.getIsReferentNeeded(),
                    demandeur.getNom(), demandeur.getPrenom(), demandeur.getAge(), demandeur.getAdresse(),
                    null, null, -1, null);
        } else {
            return new InfosMission(mission.getId(), mission.getDemandeurId(),
                    mission.getBenevoleAssigneId(),
                    mission.getSujet(), mission.getMotif(), mission.getAvis(), mission.isValidated(),
                    mission.isWaiting(),
                    mission.isRealised(), mission.isReferred(), mission.getIsReferentNeeded(),
                    demandeur.getNom(), demandeur.getPrenom(), demandeur.getAge(), demandeur.getAdresse(),
                    benevole.getNom(), benevole.getPrenom(), benevole.getAge(), benevole.getAdresse());
        }
    }

    @GetMapping("/infosToutesLesMissionsSansBenevole")
    public Collection<InfosMission> toutesLesMissionsSansBenevole() {
        Collection<InfosMission> collection = new ArrayList<InfosMission>();

        ResponseEntity<Collection<Mission>> missionsResponse = restTemplate.exchange(
                "http://aideAuxVulnerableMission/toutesLesMissionsSansBenevole",
                HttpMethod.GET, null, new ParameterizedTypeReference<Collection<Mission>>() {
                });
        Collection<Mission> missions = missionsResponse.getBody();

        for (Mission mission : missions) {
            Personne demandeur = restTemplate
                    .getForObject("http://aideAuxVulnerablePersonne/getPersonne/" + mission.getDemandeurId(), Personne.class);
            Personne benevole = restTemplate.getForObject(
                    "http://aideAuxVulnerablePersonne/getPersonne/" + mission.getBenevoleAssigneId(), Personne.class);
            if (benevole == null) {
                collection.add(new InfosMission(mission.getId(), mission.getDemandeurId(),
                        mission.getBenevoleAssigneId(),
                        mission.getSujet(), mission.getMotif(), mission.getAvis(), mission.isValidated(),
                        mission.isWaiting(),
                        mission.isRealised(), mission.isReferred(), mission.getIsReferentNeeded(),
                        demandeur.getNom(), demandeur.getPrenom(), demandeur.getAge(), demandeur.getAdresse(),
                        null, null, -1, null));
            } else {
                collection.add(new InfosMission(mission.getId(), mission.getDemandeurId(),
                        mission.getBenevoleAssigneId(),
                        mission.getSujet(), mission.getMotif(), mission.getAvis(), mission.isValidated(),
                        mission.isWaiting(),
                        mission.isRealised(), mission.isReferred(), mission.getIsReferentNeeded(),
                        demandeur.getNom(), demandeur.getPrenom(), demandeur.getAge(), demandeur.getAdresse(),
                        benevole.getNom(), benevole.getPrenom(), benevole.getAge(), benevole.getAdresse()));
            }

        }
        return collection;
    }

    @GetMapping("/infosToutesLesMissionsNonValidees")
    public Collection<InfosMission> toutesLesMissionsNonValidees() {
        Collection<InfosMission> collection = new ArrayList<InfosMission>();

        ResponseEntity<Collection<Mission>> missionsResponse = restTemplate.exchange(
                "http://aideAuxVulnerableMission/toutesLesMissionsNonValidees",
                HttpMethod.GET, null, new ParameterizedTypeReference<Collection<Mission>>() {
                });
        Collection<Mission> missions = missionsResponse.getBody();

        for (Mission mission : missions) {
            Personne demandeur = restTemplate
                    .getForObject("http://aideAuxVulnerablePersonne/getPersonne/" + mission.getDemandeurId(), Personne.class);
            Personne benevole = restTemplate.getForObject(
                    "http://aideAuxVulnerablePersonne/getPersonne/" + mission.getBenevoleAssigneId(), Personne.class);
            if (benevole == null) {
                collection.add(new InfosMission(mission.getId(), mission.getDemandeurId(),
                        mission.getBenevoleAssigneId(),
                        mission.getSujet(), mission.getMotif(), mission.getAvis(), mission.isValidated(),
                        mission.isWaiting(),
                        mission.isRealised(), mission.isReferred(), mission.getIsReferentNeeded(),
                        demandeur.getNom(), demandeur.getPrenom(), demandeur.getAge(), demandeur.getAdresse(),
                        null, null, -1, null));
            } else {
                collection.add(new InfosMission(mission.getId(), mission.getDemandeurId(),
                        mission.getBenevoleAssigneId(),
                        mission.getSujet(), mission.getMotif(), mission.getAvis(), mission.isValidated(),
                        mission.isWaiting(),
                        mission.isRealised(), mission.isReferred(), mission.getIsReferentNeeded(),
                        demandeur.getNom(), demandeur.getPrenom(), demandeur.getAge(), demandeur.getAdresse(),
                        benevole.getNom(), benevole.getPrenom(), benevole.getAge(), benevole.getAdresse()));
            }

        }
        return collection;
    }

    @GetMapping("/infosToutesLesMissionsNonReferrees")
    public Collection<InfosMission> toutesLesMissionsNonReferrees() {
        Collection<InfosMission> collection = new ArrayList<InfosMission>();

        ResponseEntity<Collection<Mission>> missionsResponse = restTemplate.exchange(
                "http://aideAuxVulnerableMission/toutesLesMissionsNonReferrees",
                HttpMethod.GET, null, new ParameterizedTypeReference<Collection<Mission>>() {
                });
        Collection<Mission> missions = missionsResponse.getBody();

        for (Mission mission : missions) {
            Personne demandeur = restTemplate
                    .getForObject("http://aideAuxVulnerablePersonne/getPersonne/" + mission.getDemandeurId(), Personne.class);
            Personne benevole = restTemplate.getForObject(
                    "http://aideAuxVulnerablePersonne/getPersonne/" + mission.getBenevoleAssigneId(), Personne.class);
            if (benevole == null) {
                collection.add(new InfosMission(mission.getId(), mission.getDemandeurId(),
                        mission.getBenevoleAssigneId(),
                        mission.getSujet(), mission.getMotif(), mission.getAvis(), mission.isValidated(),
                        mission.isWaiting(),
                        mission.isRealised(), mission.isReferred(), mission.getIsReferentNeeded(),
                        demandeur.getNom(), demandeur.getPrenom(), demandeur.getAge(), demandeur.getAdresse(),
                        null, null, -1, null));
            } else {
                collection.add(new InfosMission(mission.getId(), mission.getDemandeurId(),
                        mission.getBenevoleAssigneId(),
                        mission.getSujet(), mission.getMotif(), mission.getAvis(), mission.isValidated(),
                        mission.isWaiting(),
                        mission.isRealised(), mission.isReferred(), mission.getIsReferentNeeded(),
                        demandeur.getNom(), demandeur.getPrenom(), demandeur.getAge(), demandeur.getAdresse(),
                        benevole.getNom(), benevole.getPrenom(), benevole.getAge(), benevole.getAdresse()));
            }
        }
        return collection;
    }

    @GetMapping("/infosToutesLesMissions")
    public Collection<InfosMission> toutesLesMissions() {
        Collection<InfosMission> collection = new ArrayList<InfosMission>();

        ResponseEntity<Collection<Mission>> missionsResponse = restTemplate.exchange(
                "http://aideAuxVulnerableMission/toutesLesMissions",
                HttpMethod.GET, null, new ParameterizedTypeReference<Collection<Mission>>() {
                });
        Collection<Mission> missions = missionsResponse.getBody();

        for (Mission mission : missions) {
            Personne demandeur = restTemplate
                    .getForObject("http://aideAuxVulnerablePersonne/getPersonne/" + mission.getDemandeurId(), Personne.class);
            Personne benevole = restTemplate.getForObject(
                    "http://aideAuxVulnerablePersonne/getPersonne/" + mission.getBenevoleAssigneId(), Personne.class);
            if (benevole == null) {
                collection.add(new InfosMission(mission.getId(), mission.getDemandeurId(),
                        mission.getBenevoleAssigneId(),
                        mission.getSujet(), mission.getMotif(), mission.getAvis(), mission.isValidated(),
                        mission.isWaiting(),
                        mission.isRealised(), mission.isReferred(), mission.getIsReferentNeeded(),
                        demandeur.getNom(), demandeur.getPrenom(), demandeur.getAge(), demandeur.getAdresse(),
                        null, null, -1, null));
            } else {
                collection.add(new InfosMission(mission.getId(), mission.getDemandeurId(),
                        mission.getBenevoleAssigneId(),
                        mission.getSujet(), mission.getMotif(), mission.getAvis(), mission.isValidated(),
                        mission.isWaiting(),
                        mission.isRealised(), mission.isReferred(), mission.getIsReferentNeeded(),
                        demandeur.getNom(), demandeur.getPrenom(), demandeur.getAge(), demandeur.getAdresse(),
                        benevole.getNom(), benevole.getPrenom(), benevole.getAge(), benevole.getAdresse()));
            }
        }
        return collection;
    }
}
