package com.Veera_Sathvik.AMS.services;

import java.util.List;
import java.util.Optional;

import com.Veera_Sathvik.AMS.entities.Hangar;

public interface HangarService {

	public List<Hangar> getHangars();

	public Hangar saveHangar(Hangar hangar);

	public Optional<Hangar> getHangar(long hid);

	public void deleteHangar(long hid);

}
