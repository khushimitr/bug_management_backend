package com.example.springbugtracker.service.impl;

import com.example.springbugtracker.exception.general.ResourceCanNotBeDeleteException;
import com.example.springbugtracker.exception.general.ResourceNotFoundException;
import com.example.springbugtracker.mapper.TeamMapper;
import com.example.springbugtracker.model.domain.entity.Team;
import com.example.springbugtracker.model.domain.entity.User;
import com.example.springbugtracker.model.dto.TeamDto;
import com.example.springbugtracker.repository.TeamRepository;
import com.example.springbugtracker.repository.UserRepository;
import com.example.springbugtracker.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    private Team giveTeamById(Integer id) {
        return this.teamRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Team", "team id", id.toString()));
    }

    @Override
    public TeamDto insertNewTeam(TeamDto teamDto) {
        Team team = TeamMapper.toEntity(teamDto);
        return TeamMapper.toDto(teamRepository.save(team));
    }

    @Override
    public TeamDto updateTeam(Integer id, TeamDto teamDto) {
        Team team = this.giveTeamById(id);
        team = TeamMapper.partialUpdate(teamDto, team);
        return TeamMapper.toDto(teamRepository.save(team));
    }

    @Override
    public TeamDto getTeamById(Integer id) {
        return TeamMapper.toDto(this.giveTeamById(id));
    }

    @Override
    public TeamDto deleteTeamById(Integer id) {
        Team team = this.giveTeamById(id);
        this.teamRepository.delete(team);
        if (!this.teamRepository.existsById(id))
            return TeamMapper.toDto(team);
        else
            throw new ResourceCanNotBeDeleteException("Team", "team id", id.toString());
    }

    @Override
    public TeamDto updateMembers(Integer id, TeamDto teamDto) {
        Team team = this.giveTeamById(id);
        team = TeamMapper.partialUpdate(teamDto, team);
        return TeamMapper.toDto(teamRepository.save(team));
    }

    @Override
    public Set<TeamDto> findByManager_Id(Integer id) {
        return TeamMapper.teamSetToTeamDtoSet(this.teamRepository.findByManager_Id(id));
    }

    @Override
    public List<TeamDto> findByProjects_Id(Integer id) {
        return this.teamRepository.findByProjects_Id(id).stream().map(TeamMapper::toDto).toList();
    }
}
