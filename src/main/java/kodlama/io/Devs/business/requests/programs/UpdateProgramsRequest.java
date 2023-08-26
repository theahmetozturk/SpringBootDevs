package kodlama.io.Devs.business.requests.programs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProgramsRequest {

	private int id;
	private String name;
}
