package med.voll.api.domain.pacientes;

import med.voll.api.domain.endereco.Endereco;

public record DTODetalhamentoPaciente(Long id, String nome, String telefone, String email, String cpf, Endereco endereco) {
    public DTODetalhamentoPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getTelefone(), paciente.getEmail(), paciente.getCpf(), paciente.getEndereco());
    }
}
