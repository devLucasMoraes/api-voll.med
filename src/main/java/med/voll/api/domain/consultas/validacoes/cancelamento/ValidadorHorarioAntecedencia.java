package med.voll.api.domain.consultas.validacoes.cancelamento;

import med.voll.api.domain.consultas.ConsultaRepository;
import med.voll.api.domain.consultas.DTOCancelamentoConsulta;
import med.voll.api.domain.consultas.validacoes.exeptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorCancelamentoDeConsulta{
    @Autowired
    private ConsultaRepository consultaRepository;

    @Override
    public void validar(DTOCancelamentoConsulta dados) {
        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
        var agora = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(agora, consulta.getData()).toHours();

        if (diferencaEmHoras < 24) {
            throw new ValidacaoException("Consulta somente pode ser cancelada com antecedência mínima de 24h!");
        }
    }
}
