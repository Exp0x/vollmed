package med.voll.api.domain.consulta.validacoes.cancelamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosCancelamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedenciaDoCancelamento implements ValidadorCancelamentoDeConsulta {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosCancelamentoConsulta dados) {
        var dataConsulta = repository.getReferenceById(dados.idConsulta()).getData();
        var agora = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(dataConsulta, agora).toHours();

        if (diferencaEmHoras < 24) {
            throw new ValidacaoException("Consulta deve ser cancelada com antecedência mínima de 24 Horas");
        }
    }
}
