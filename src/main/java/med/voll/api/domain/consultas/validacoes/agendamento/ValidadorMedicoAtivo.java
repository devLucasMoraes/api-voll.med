package med.voll.api.domain.consultas.validacoes.agendamento;

import med.voll.api.domain.consultas.DTOAgendamentoConsulta;
import med.voll.api.domain.consultas.validacoes.exeptions.ValidacaoException;
import med.voll.api.domain.medicos.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo {
    @Autowired
    private MedicoRepository medicoRepository;

    public void validar(DTOAgendamentoConsulta dados) {
        //escolha do medico opcional
        if (dados.idMedico() == null) {
            return;
        }

        var medicoEstaAtivo = medicoRepository.findAtivoById(dados.idMedico());
        if (!medicoEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com médico excluído");
        }
    }
}
