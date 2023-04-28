package med.voll.api.domain.consultas.validacoes.cancelamento;

import med.voll.api.domain.consultas.DTOCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {
    public void validar(DTOCancelamentoConsulta dados);
}
