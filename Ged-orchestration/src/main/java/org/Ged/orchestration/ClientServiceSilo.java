package org.Ged.orchestration;

import org.Ged.dto.ClientDto;
import org.Ged.model.Client;

public interface ClientServiceSilo {
	ClientDto saveClient(Client c);
}
