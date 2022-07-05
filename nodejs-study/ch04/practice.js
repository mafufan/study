const http = require('http');
const fs = require('fs');
const url = require('url');
const qs = require('querystring');

const cookie = 'a=1;b=2;c=3';

const parseCookies = (cookie = '') => {
  cookie
    .split('/')
    .map(v => v.split('='))
    .reduce((acc, [k, v]) => {
      acc[k.trim()] = decodeURIComponent(v);
      return acc;
    }, {});
};
