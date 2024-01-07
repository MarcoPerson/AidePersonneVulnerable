## **Documentation du Microservice AideAuxVulnerablePersonne**

Ceci fournit des informations détaillées sur l'utilisation du microservice AideAuxVulnerablePersonne. Ce microservice est conçu pour gérer les opérations liées aux personnes dans le contexte du système d'aide aux personnes vulnérables.

### Endpoints

#### 1. Ajouter une personne
   - **Endpoint:** `/ajoutPersonne`
   - **Type de requête:** POST
   - **Paramètres:**
     - `personne` (Objet JSON) - Les détails de la personne à ajouter au format JSON.
       - `nom` (String) - Le nom de la personne.
       - `prenom` (String) - Le prénom de la personne.
       - `age` (int) - L'âge de la personne.
       - `adresse` (String) - L'adresse de la personne.
       - `isReferentNeeded` (Boolean) - Indique si un référent est nécessaire pour cette personne.
       - `role` (String) - Le rôle de la personne, parmi les valeurs suivantes : "Benevole", "Demandeur", "Validateur", "Referent".
   - **Réponse:**
     - Retourne `true` après l'ajout réussi de la personne.

#### 2. Obtenir une personne spécifique
   - **Endpoint:** `/getPersonne/{personneId}`
   - **Type de requête:** GET
   - **Paramètres:**
     - `personneId` (int) - L'identifiant unique de la personne à récupérer.
   - **Réponse:**
     - Retourne l'objet `Personne` correspondant à l'identifiant de personne spécifié.

#### 3. Supprimer une personne
   - **Endpoint:** `/supprimerPersonne/{personneId}`
   - **Type de requête:** GET
   - **Paramètres:**
     - `personneId` (int) - L'identifiant unique de la personne à supprimer.
   - **Réponse:**
     - Retourne `true` après la suppression réussie de la personne.

#### 4. Obtenir toutes les personnes
   - **Endpoint:** `/toutesLesPersonnes`
   - **Type de requête:** GET
   - **Réponse:**
     - Retourne une collection d'objets `Personne` représentant toutes les personnes enregistrées.

#### 5. Obtenir tous les demandeurs
   - **Endpoint:** `/tousLesDemandeurs`
   - **Type de requête:** GET
   - **Réponse:**
     - Retourne une collection d'objets `Personne` représentant tous les demandeurs enregistrés.

#### 6. Obtenir tous les validateurs
   - **Endpoint:** `/tousLesValidateurs`
   - **Type de requête:** GET
   - **Réponse:**
     - Retourne une collection d'objets `Personne` représentant tous les validateurs enregistrés.

#### 7. Obtenir tous les bénévoles
   - **Endpoint:** `/tousLesBenevoles`
   - **Type de requête:** GET
   - **Réponse:**
     - Retourne une collection d'objets `Personne` représentant tous les bénévoles enregistrés.

#### 8. Obtenir tous les référents
   - **Endpoint:** `/tousLesReferents`
   - **Type de requête:** GET
   - **Réponse:**
     - Retourne une collection d'objets `Personne` représentant tous les référents enregistrés.


## **Documentation du Microservice AideAuxVulnerableMission**

Ceci fournit des informations détaillées sur l'utilisation du microservice AideAuxVulnerableMission. Ce microservice est conçu pour gérer les opérations liées aux missions dans le contexte du système d'aide aux personnes vulnérables.

### Endpoints

#### 1. Ajouter une mission
   - **Endpoint:** `/ajoutMission`
   - **Type de requête:** POST
   - **Paramètres:**
     - `mission` (Objet JSON) - Les détails de la mission à ajouter au format JSON.
       - `demandeurId` (int) - L'identifiant unique du demandeur de la mission.
       - `sujet` (String) - Le sujet de la mission.
       - `isReferentNeeded` (boolean) - Indique si un référent est nécessaire pour cette mission.
   - **Réponse:**
     - Retourne `true` après l'ajout réussi de la mission avec des états de mission par défaut.

#### 2. Assigner une mission à un bénévole
   - **Endpoint:** `/assignerMission/{missionId}/{benevoleId}`
   - **Type de requête:** PUT
   - **Paramètres:**
     - `missionId` (int) - L'identifiant unique de la mission à assigner.
     - `benevoleId` (int) - L'identifiant unique du bénévole assigné.
   - **Réponse:**
     - Retourne `true` après la mise à jour réussie de la mission avec le bénévole assigné.

#### 3. Référer une mission
   - **Endpoint:** `/referrerMission/{missionId}`
   - **Type de requête:** PUT
   - **Paramètres:**
     - `missionId` (int) - L'identifiant unique de la mission à référencer.
   - **Réponse:**
     - Retourne `true` après la mise à jour réussie de la mission avec le statut de référencement.

#### 4. Valider une mission
   - **Endpoint:** `/validerMission/{missionId}`
   - **Type de requête:** PUT
   - **Paramètres:**
     - `missionId` (int) - L'identifiant unique de la mission à valider.
   - **Réponse:**
     - Retourne `true` après la mise à jour réussie de la mission avec le statut de validation.

#### 5. Refuser une mission
   - **Endpoint:** `/refuserMission/{missionId}`
   - **Type de requête:** POST
   - **Paramètres:**
     - `missionId` (int) - L'identifiant unique de la mission à refuser.
     - `motif` (Objet JSON contenant un champ "motif") - Le contenu du motif à ajouter.
   - **Réponse:**
     - Retourne `true` après la mise à jour réussie de la mission avec le motif de refus.

#### 6. Marquer une mission comme complète
   - **Endpoint:** `/completeMission/{missionId}`
   - **Type de requête:** PUT
   - **Paramètres:**
     - `missionId` (int) - L'identifiant unique de la mission à marquer comme complète.
   - **Réponse:**
     - Retourne `true` après la mise à jour réussie de la mission avec le statut de réalisation.

#### 7. Ajouter un avis à une mission
   - **Endpoint:** `/ajoutAvisMission/{missionId}`
   - **Type de requête:** POST
   - **Paramètres:**
     - `missionId` (int) - L'identifiant unique de la mission à laquelle ajouter un avis.
     - `avis` (Objet JSON contenant un champ "avis") - Le contenu de l'avis à ajouter.
   - **Réponse:**
     - Retourne `true` après la mise à jour réussie de la mission avec l'avis.

#### 8. Obtenir une mission spécifique
   - **Endpoint:** `/getMission/{missionId}`
   - **Type de requête:** GET
   - **Paramètres:**
     - `missionId` (int) - L'identifiant unique de la mission à récupérer.
   - **Réponse:**
     - Retourne l'objet `Mission` correspondant à l'identifiant de mission spécifié.

#### 9. Obtenir les missions d'un demandeur
   - **Endpoint:** `/getMissionsDemandeur/{demandeurId}`
   - **Type de requête:** GET
   - **Paramètres:**
     - `demandeurId` (int) - L'identifiant unique du demandeur pour lequel récupérer les missions.
   - **Réponse:**
     - Retourne une collection d'objets `Mission` représentant les missions du demandeur.

#### 10. Obtenir les missions d'un bénévole
   - **Endpoint:** `/getMissionsBenevole/{benevoleId}`
   - **Type de requête:** GET
   - **Paramètres:**
     - `benevoleId` (int) - L'identifiant unique du bénévole pour lequel récupérer les missions.
   - **Réponse:**
     - Retourne une collection d'objets `Mission` représentant les missions du bénévole.

#### 11. Obtenir toutes les missions sans bénévole assigné
   - **Endpoint:** `/toutesLesMissionsSansBenevole`
   - **Type de requête:** GET
   - **Réponse:**
     - Retourne une collection d'objets `Mission` représentant toutes les missions sans bénévole assigné.

#### 12. Obtenir toutes les missions non validées
   - **Endpoint:** `/toutesLesMissionsNonValidees`
   - **Type de requête:** GET
   - **Réponse:**
     - Retourne une collection d'objets `Mission` représentant toutes les missions non validées.

#### 13. Obtenir toutes les missions non référencées
   - **Endpoint:** `/toutesLesMissionsNonReferrees`
   - **Type de requête:** GET
   - **Réponse:**
     - Retourne une collection d'objets `Mission` représentant toutes les missions non référencées.

#### 14. Obtenir toutes les missions
   - **Endpoint:** `/toutesLesMissions`
   - **Type de requête:** GET
   - **Réponse:**
     - Retourne une collection d'objets `Mission` représentant toutes les missions.


## **Documentation du Microservice AideAuxVulnerableRelation**

Ceci fournit des informations détaillées sur l'utilisation du microservice AideAuxVulnerableRelation. Ce microservice est conçu pour récupérer des informations sur les relations entre les personnes et les missions dans le contexte du système d'aide aux personnes vulnérables.

### Endpoints

#### 1. Obtenir les informations sur une personne
   - **Endpoint:** `/infosPersonne/{personneId}`
   - **Type de requête:** GET
   - **Paramètres:**
     - `personneId` (int) - L'identifiant unique de la personne dont vous souhaitez obtenir des informations.
   - **Réponse:**
     - Retourne un objet `InfosPersonne` contenant des détails sur la personne, y compris ses missions associées.

#### 2. Obtenir les informations sur une mission
   - **Endpoint:** `/infosMission/{missionId}`
   - **Type de requête:** GET
   - **Paramètres:**
     - `missionId` (int) - L'identifiant unique de la mission dont vous souhaitez obtenir des informations.
   - **Réponse:**
     - Retourne un objet `InfosMission` contenant des détails sur la mission, y compris les informations sur le demandeur et le bénévole assigné.

#### 3. Obtenir toutes les missions sans bénévole assigné
   - **Endpoint:** `/infosToutesLesMissionsSansBenevole`
   - **Type de requête:** GET
   - **Réponse:**
     - Retourne une collection d'objets `InfosMission` représentant toutes les missions sans bénévole assigné.

#### 4. Obtenir toutes les missions non validées
   - **Endpoint:** `/infosToutesLesMissionsNonValidees`
   - **Type de requête:** GET
   - **Réponse:**
     - Retourne une collection d'objets `InfosMission` représentant toutes les missions non validées.

#### 5. Obtenir toutes les missions non référencées
   - **Endpoint:** `/infosToutesLesMissionsNonReferrees`
   - **Type de requête:** GET
   - **Réponse:**
     - Retourne une collection d'objets `InfosMission` représentant toutes les missions non référencées.

#### 6. Obtenir toutes les missions
   - **Endpoint:** `/infosToutesLesMissions`
   - **Type de requête:** GET
   - **Réponse:**
     - Retourne une collection d'objets `InfosMission` représentant toutes les missions.

Pour plus de détails sur les modèles `InfosPersonne` et `InfosMission`, veuillez consulter les classes correspondantes dans le package `MarcoWalter.AideAuxVulnerableRelation.model`.
