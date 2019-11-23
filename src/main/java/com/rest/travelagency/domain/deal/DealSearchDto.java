package com.rest.travelagency.domain.deal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DealSearchDto {

    private String city;
    private LocalDate dateFrom;
    private LocalDate dateTo;
}
