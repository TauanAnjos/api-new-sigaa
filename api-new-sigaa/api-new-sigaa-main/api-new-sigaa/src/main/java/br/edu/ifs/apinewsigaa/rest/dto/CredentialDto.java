package br.edu.ifs.apinewsigaa.rest.dto;

import lombok.Data;

@Data
public class CredentialDto {
    private String type;
    private String value;
    private boolean temporary;
}
