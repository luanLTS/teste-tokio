package br.com.tokiomarine.seguradora.mapper;

import br.com.tokiomarine.seguradora.dto.ViaCepDto;
import br.com.tokiomarine.seguradora.model.Address;

public class AddressMapper {

    public static void toAddress(ViaCepDto source, Address target) {
        target.setAddress(source.getLogradouro());
        target.setPostalCode(source.getCep());
        target.setCity(source.getLocalidade());
        target.setState(source.getEstado());
        if (target.getComplement() == null || target.getComplement().isEmpty())
            target.setComplement(source.getComplemento());
    }

}
