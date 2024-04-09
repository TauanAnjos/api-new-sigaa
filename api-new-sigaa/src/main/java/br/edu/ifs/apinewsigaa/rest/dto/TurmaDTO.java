package br.edu.ifs.apinewsigaa.rest.dto;

import lombok.Data;

import java.util.Date;

public record TurmaDTO(Date dataInicio, Date dataFim) {
}
