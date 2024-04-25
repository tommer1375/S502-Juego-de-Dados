package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.services;


import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.domain.Game;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.domain.Player;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.dto.GameDTO;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.exceptions.*;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.repository.GameRepository;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.repository.PlayerRepository;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.services.GameService;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.utils.GameConverter;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.utils.PlayerConverter;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


    @Service
    public class PlayerServiceImpl implements PlayerService {

        @Autowired
        private PlayerRepository playerRepository;

        @Override
        public PlayerDTO addPlayer(PlayerDTO playerDTO) {
            if (playerDTO.getName() == null || playerDTO.getName().isBlank() || playerDTO.getName().equalsIgnoreCase("Unnamed")) {
                playerDTO.setName("Unnamed");
            } else if (playerRepository.existsByNameIgnoreCase(playerDTO.getName())) {
                throw new PlayerAlreadyExists("Player already exists.");
            }
            return setNewPlayer(playerDTO);
        }

        @Override
        public PlayerDTO updatePlayer(String playerId, PlayerDTO newPlayerDTO) {
            Player playerToUpdate = findPlayerById(playerId);

            if (newPlayerDTO.getName() == null || newPlayerDTO.getName().isBlank()) {
                newPlayerDTO.setName("Unnamed");
            } else if (playerRepository.existsByNameIgnoreCase(newPlayerDTO.getName())) {
                throw new PlayerAlreadyExists("Player already exists.");
            }
            playerToUpdate.setName(newPlayerDTO.getName());
            playerRepository.save(playerToUpdate);
            return PlayerConverter.EntitytoDTO(playerToUpdate);

        }

        @Override
        public List<PlayerDTO> getAllPlayers() {

            List<Player> playerList = playerRepository.findAll();
            if (playerList.isEmpty()) {
                throw new PlayerNotFound("The players list is Empty");
            }
            return playerList.stream().map(PlayerConverter::EntitytoDTO)
                    .collect(Collectors.toList());
        }


        private PlayerDTO setNewPlayer(PlayerDTO playerDTO) {

            playerDTO.setName(playerDTO.getName());
            playerDTO.setRegisterDate(LocalDateTime.now());
            Player player = PlayerConverter.DTOtoEntity(playerDTO);
            playerRepository.save(player);
            return PlayerConverter.EntitytoDTO(player);
        }

        public Player findPlayerById(String playerId) {
            return playerRepository.findById(playerId)
                    .orElseThrow(() -> new PlayerNotFound("Player not found."));
        }


        public Player savePlayer(Player player) {
            return playerRepository.save(player);
        }


    }

