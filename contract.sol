contract valid {
	
	bytes32 profileAdr;
	mapping( bytes32=>bytes32) public _name;
	mapping( bytes32=>bytes32) public _city;
	mapping( bytes32=>uint256) public _dob;
	mapping( bytes32=>bool) public _verified;
	
	function newProfile( bytes32 adr, bytes32 name,bytes32 city, uint256 dob){
		profileAdr = adr;
		_name[profileAdr] = name;
		_city[profileAdr] = city;
		_dob[profileAdr] = dob;
		_verified[profileAdr]=false;
	}
	
	function getProfile(bytes32 addr) returns( bytes32 name, bytes32 city,uint256 dob){
		name = _name[profileAdr];
		dob = _dob[profileAdr];
		city = _city[profileAdr];
	}
	
	function verify(bytes32 addr ) {
		_verified[addr]=true;
	}
}
