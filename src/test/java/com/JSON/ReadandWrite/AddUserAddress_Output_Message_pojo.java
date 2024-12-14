package com.JSON.ReadandWrite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserAddress_Output_Message_pojo {
	 public int status;
	    public String message;
	    public int address_id;
}
