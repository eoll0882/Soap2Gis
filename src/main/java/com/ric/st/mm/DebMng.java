package com.ric.st.mm;

import java.math.BigDecimal;

import com.ric.bill.model.oralv.Ko;
import com.ric.dto.SumSaldoRecDTO;

/**
 * Интерфейс сервиса получения данных о задолженности, пени из разных источников
 * @author Lev
 *
 */
public interface DebMng {

	BigDecimal getPenAmnt(String lsk, Ko ko, String period, Integer appTp);
	SumSaldoRecDTO getSumSaldo(String lsk, Ko ko, String period, Integer appTp);
}
