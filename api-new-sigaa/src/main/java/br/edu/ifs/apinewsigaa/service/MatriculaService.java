package br.edu.ifs.apinewsigaa.service;

import br.edu.ifs.apinewsigaa.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaService {
    @Autowired
    private MatriculaRepository matriculaRepository;
}
