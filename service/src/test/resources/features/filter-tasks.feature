# language: fr
Fonctionnalité: Voir les tâches terminées

  Règle: Les tâches peuvent être filtrées par leur statut. Seules les tâches du statut choisi seront proposées

  En tant qu'utilisateur
  Je souhaite lister les tâches
  Pour voir le travail accompli

    Scénario: Filtrer les tâches en cours
      Etant donné les tâches à faire
        | Aller au parc Asterix |
        | Aller au bar |
      Et les tâches terminées
        | Aller courrir |
        | Sauter dans le vide |
      Quand les tâches en cours sont demandées
      Alors les tâches proposées sont
        | Aller au parc Asterix |
        | Aller au bar |

    Scénario: Filtrer les tâches terminées
      Etant donnée les tâches à faire
        | Ajouter des fonctionnalités à mon projet |
        | Refactorer mon projet |
      Et les tâches terminées
        | Commencer la pratique de l'event sourcing |
        | Commencer la pratique du DDD |
      Quand les tâches terminées sont demandées
      Alors les tâches proposées sont
        | Commencer la pratique de l'event sourcing |
        | Commencer la pratique du DDD |
