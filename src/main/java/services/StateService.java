package services;

import entities.state.State;
import entities.state.StateDTO;
import entities.state.StateName;
import entities.state.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {
    private final StateRepository stateRepository;

    public StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public Optional<State> findById(Long id) {
        return stateRepository.findById(id);
    }

    public Optional<State> findByName(String stateName) {
        StateName name = StateName.valueOf(stateName);
        return stateRepository.findByName(name);
    }

    public Optional<State> findByName(StateName name) {
        return stateRepository.findByName(name);
    }

    public List<State> getAll() {
        return this.stateRepository.findAll();
    }

    public State save(StateName name){
        State state = new State(null, name);
        return this.stateRepository.save(state);
    }
}
