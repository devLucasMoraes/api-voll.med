package med.voll.api.domain.medicos;

public record DTOListagemMedicos(Long id, String nome, String email, String crm, Especialidade especialidade) {
    public DTOListagemMedicos(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
