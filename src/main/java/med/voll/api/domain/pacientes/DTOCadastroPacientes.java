package med.voll.api.domain.pacientes;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.DTOEndereco;

public record DTOCadastroPacientes(

        @NotBlank
        String nome,
        @NotBlank @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        String cpf,
        @NotNull @Valid
        DTOEndereco endereco
) {

}
