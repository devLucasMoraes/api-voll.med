package med.voll.api.domain.pacientes;


public record DTOListagemPacientes(Long id, String nome, String email, String cpf) {
    public DTOListagemPacientes(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
