package br.com.whister.whisteragendamentosapi.entity;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class Calculadora {

    public Consulta calculaValorConsulta(Consulta consulta) {
        double descontoTotal;

        Double descontoEspecialidade = consulta.getMedico().getEspecialidade().getDescontoPromocional();

        Double adicionalPorcentagemEspecial = consulta.getMedico().getEspecialidade().getPorcentagemEspecial();

        Double descontoPorcentagemPlano = consulta.getPaciente().getPlano().getDesconto();

        BigDecimal valorBrutoConsulta = consulta.getValorBruto();

        BigDecimal valorFinal = new BigDecimal("0.00");

        double adicionalTotal;


        descontoTotal = ((valorBrutoConsulta.doubleValue() / descontoPorcentagemPlano) * 100)
                + ((valorBrutoConsulta.doubleValue() / descontoEspecialidade) * 100);

        valorFinal.add(valorBrutoConsulta.subtract(BigDecimal.valueOf(descontoTotal)));

        consulta.setValorDescontos(BigDecimal.valueOf(descontoTotal));

        consulta.setValorFinal(valorFinal);

        if (consulta.getEspecial()) {

            adicionalTotal = (valorFinal.doubleValue()/ adicionalPorcentagemEspecial) * 100;

            consulta.setValorFinal(valorFinal.add(BigDecimal.valueOf(adicionalTotal)));

        }
        return consulta;
    }
}
