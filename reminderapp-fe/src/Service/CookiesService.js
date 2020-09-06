import Cookies from 'universal-cookie';

const cookies = new Cookies();

const Cookie = {

	setCookie(name, value, opts) {
		return cookies.set(name, value, true);
	},

	getCookie(){
		return cookies.get("person");
	},

	removeCookie() {
		return cookies.remove("person");
	},

	checkLogin() {
		var cookieExists = this.getCookie("person");
		if (cookieExists != null) {
			return true;
		}
		return false;
	}

}

export default Cookie;