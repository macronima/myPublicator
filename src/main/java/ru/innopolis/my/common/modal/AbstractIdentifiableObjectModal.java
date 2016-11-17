package ru.innopolis.my.common.modal;

import lombok.Data;

@Data
abstract class AbstractIdentifiableObjectModal {

    private Long id;
    private Long version;

}
