package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.ProgramService;
import kodlama.io.Devs.business.requests.programs.CreateProgramsRequest;
import kodlama.io.Devs.business.requests.programs.DeleteProgramsRequest;
import kodlama.io.Devs.business.requests.programs.UpdateProgramsRequest;
import kodlama.io.Devs.business.responses.GetAllProgramsResponse;
import kodlama.io.Devs.dataAccess.ProgramRepository;
import kodlama.io.Devs.entities.concretes.Programs;

@Service
public class ProgramManager implements ProgramService {
	private ProgramRepository programRepository;

	@Autowired
	public ProgramManager(ProgramRepository programRepository) {

		this.programRepository = programRepository;
	}

	@Override
	public List<GetAllProgramsResponse> getAll() {

		List<Programs> programs = programRepository.findAll();
		List<GetAllProgramsResponse> programsResponses = new ArrayList<GetAllProgramsResponse>();

		for (Programs program : programs) {
			GetAllProgramsResponse responseItem = new GetAllProgramsResponse();
			responseItem.setId(program.getId());
			responseItem.setName(program.getName());
			programsResponses.add(responseItem);
		}

		return programsResponses;
	}

	@Override
	public boolean add(CreateProgramsRequest createProgramsRequest) throws Exception {

		Programs program = new Programs();
		program.setName(createProgramsRequest.getName());

		Programs pr = programRepository.findByName(createProgramsRequest.getName());

		if (pr != null) {
			throw new Exception("This name already exist. You can't add!!");
		}

		if (createProgramsRequest.getName().isBlank()) {
			throw new Exception("Name can't be blank");
		}

		programRepository.save(program);
		return true;
	}

	@Override
	public boolean delete(DeleteProgramsRequest deleteProgramsRequest) {
		programRepository.deleteById(deleteProgramsRequest.getId());
		return true;
	}

	@Override
	public boolean update(UpdateProgramsRequest updateProgramsRequest) throws Exception {
		Programs pr = programRepository.findByName(updateProgramsRequest.getName());

		if (pr != null) {
			throw new Exception("This name already exist. You can't update!!");
		}
		pr.setName(updateProgramsRequest.getName());
		programRepository.save(pr);
		return true;
	}

}
