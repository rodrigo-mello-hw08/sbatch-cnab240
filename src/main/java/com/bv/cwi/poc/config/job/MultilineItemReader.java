package com.bv.cwi.poc.config.job;

import com.bv.cwi.poc.domain.DetalheSegmentoA;
import com.bv.cwi.poc.domain.DetalheSegmentoB;
import com.bv.cwi.poc.domain.LinhaCnab;
import com.bv.cwi.poc.domain.RegistroCnab;
import com.bv.cwi.poc.domain.enums.CampoDetalheAEnum;
import com.bv.cwi.poc.domain.enums.CampoDetalheBEnum;
import org.springframework.batch.item.*;
import org.springframework.batch.item.file.FlatFileItemReader;

public class MultilineItemReader implements ItemReader<RegistroCnab>, ItemStream {
    private final FlatFileItemReader<LinhaCnab> delegate;
    private LinhaCnab linhaAtual;

    public MultilineItemReader(FlatFileItemReader<LinhaCnab> delegate) {
        this.delegate = delegate;
    }

    @Override
    public RegistroCnab read() throws Exception {
        RegistroCnab registroCnab = new RegistroCnab();
        do {
            this.linhaAtual = this.delegate.read();
            if (this.linhaAtual == null) break;
            mapearLinhar(registroCnab);

        } while(!registroCnab.registroCompleto());

        return registroCnab.registroCompleto() ? registroCnab : null;
    }

    private void mapearLinhar(RegistroCnab registroCnab) {
        switch (this.linhaAtual.obterIdentificador()) {
            case CampoDetalheAEnum.IDENTIFICADOR:
                registroCnab.setDetalheSegmentoA((DetalheSegmentoA) this.linhaAtual);
                break;
            case CampoDetalheBEnum.IDENTIFICADOR:
                registroCnab.setDetalheSegmentoB((DetalheSegmentoB) this.linhaAtual);
                break;
            default:
                break;
        }
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        this.delegate.open(executionContext);
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        this.delegate.update(executionContext);
    }

    @Override
    public void close() throws ItemStreamException {
        this.delegate.close();
    }
}
