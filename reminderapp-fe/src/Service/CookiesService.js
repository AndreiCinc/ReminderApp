import Cookies from 'universal-cookie';

const cookies = new Cookies();

const Cookie = {

	setCookie(name, value, opts) {
		return cookies.set(name, value, opts);
	},

	getCookie(name) {
		return cookies.get(name);
	},

	removeCookie(name) {
		return cookies.remove(name );
	}

}

export default Cookie;