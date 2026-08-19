package br.com.whister.whisteragendamentosapi.entity;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class Calculadora {

    public Consulta calculaValorConsulta(Consulta consulta) {
        BigDecimal descontoTotal = new BigDecimal("0.00");

        Double descontoEspecialidade = consulta.getMedico().getEspecialidade().getDescontoPromocional();

        Double adicionalPorcentagemEspecial = consulta.getMedico().getEspecialidade().getPorcentagemEspecial();

        Double descontoPorcentagemPlano = consulta.getPaciente().getPlano().getDesconto();

        BigDecimal valorBrutoConsulta = consulta.getValorBruto();

        BigDecimal valorFinal = new BigDecimal("0.00");

        BigDecimal adicionalTotal = new BigDecimal("0.00");


        descontoTotal = descontoTotal.add((BigDecimal.valueOf(descontoPorcentagemPlano).multiply(valorBrutoConsulta)).divide(BigDecimal.valueOf(100)));
        descontoTotal = descontoTotal.add((BigDecimal.valueOf(descontoEspecialidade).multiply(valorBrutoConsulta)).divide(BigDecimal.valueOf(100)));

        valorFinal = valorFinal.add(valorBrutoConsulta.subtract(descontoTotal));

        consulta.setValorDescontos(descontoTotal);

        consulta.setValorFinal(valorFinal);

        if (consulta.getEspecial()) {

            adicionalTotal = adicionalTotal.add(valorFinal.multiply(BigDecimal.valueOf(adicionalPorcentagemEspecial))).divide(BigDecimal.valueOf(100));

            valorFinal = valorFinal.add(adicionalTotal);

            consulta.setValorFinal(valorFinal);

        }
        return consulta;
    }
}
