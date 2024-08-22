package med.voll.api.domain.consulta.validacoes.cancelamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosCancelamentoConsulta;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMotivoDoCancelamento implements ValidadorCancelamentoDeConsulta {
    public void validar(DadosCancelamentoConsulta dados) {
            if (dados.motivo() == null) {
                throw new ValidacaoException("Não foi informado o motivo do cancelamento");
            }
    }
}
