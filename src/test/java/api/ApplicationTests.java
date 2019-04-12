/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import api.Repository.ProgramRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ProgramRepository programRepository;

	@Before
	public void deleteAllBeforeTests() throws Exception {
		programRepository.deleteAll();
	}
	
	
	@Test
    public void test() throws Exception {
		String filepath = "/개발_과제1_지자체협약지원정보_16년12월현재__최종.csv";
       // unit테스트 작성 for csv file upload
		
//        MockMultipartFile mockMultipartFile = new MockMultipartFile("file",filepath,
//                "text/plain", "file".getBytes());
//        
//       
//        mockMvc.perform((RequestBuilder) ((ResultActions) MockMvcRequestBuilders.multipart("/loadCSV")
//                        .file(mockMultipartFile))
//                    .andExpect(status().is(200)));
                  
    }
	
	
	
	
}