'use strict';

const convertNumberStr = (number = 0, prefix = '', suffix = '') => {
	let str = typeof number === 'string' ? new Intl.NumberFormat().format(parseInt(number)) : new Intl.NumberFormat().format(number);
	return `${prefix}${str}${suffix}`;
};

const convertDateStr = (time = new Date(), type = 'full', separator = { date: '-', time: ':' }) => {
	const date = time === 'object' ? time : new Date(time);
	const dateSeparator = typeof separator === 'string' ? separator : separator.date;
	const timeSeparator = typeof separator === 'string' ? separator : separator.time;
	let m, d, y, h, mm, s;

	if (type === 'full' || type === 'date') {
		m = date.getMonth() + 1 > 10 ? date.getMonth() + 1 : `0${date.getMonth() + 1}`;
		d = date.getDate() > 10 ? date.getDate() : `0${date.getDate()}`;
		y = date.getFullYear();
	}

	if (type === 'full' || type === 'time') {
		h = date.getHours() > 10 ? date.getHours() : `0${date.getHours()}`;
		mm = date.getMinutes() > 10 ? date.getMinutes() : `0${date.getMinutes()}`;
		s = date.getSeconds() > 10 ? date.getSeconds() : `0${date.getSeconds()}`;
	}

	switch (type) {
		case 'date': return `${[y, m, d].join(dateSeparator)}`;
		case 'time': return `${[h, mm, s].join(timeSeparator)}`;
		default: return `${[y, m, d].join(dateSeparator)} ${[h, mm, s].join(timeSeparator)}`;
	}
};