package med.voll.api.domain.medicos;


import med.voll.api.domain.endereco.Endereco;

public record DTODetalhamentoMedico(Long id, String nome, String telefone, String email, String crm, Especialidade especialidade, Endereco endereco) {
    public DTODetalhamentoMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getTelefone(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
    }
}
