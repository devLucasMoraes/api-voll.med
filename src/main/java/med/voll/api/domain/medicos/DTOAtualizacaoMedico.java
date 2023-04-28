package med.voll.api.domain.medicos;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.DTOEndereco;

public record DTOAtualizacaoMedico(@NotNull Long id, String nome, String telefone, DTOEndereco endereco) {

}
