package co.com.claro.warrantyEquipments.model;

import co.com.claro.warrantyEquipments.entity.WarCav;
import java.util.List;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DataResponse {

    @Getter
    @Setter
    private GenericResponse response;

    @Getter
    @Setter
    private List<WarCav> cavs;

}
