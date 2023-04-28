package med.voll.api.domain.pacientes;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.DTOEndereco;

public record DTOAtualizacaoPaciente(@NotNull Long id, String nome, String telefone, DTOEndereco endereco) {
}
