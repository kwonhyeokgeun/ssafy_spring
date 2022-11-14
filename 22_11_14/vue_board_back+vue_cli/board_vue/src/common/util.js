export default{

   makeDateStr(year, month, day, type) { // type + / or . (ex)2022/7/24
    return year + type + ((month < 10) ? '0' + month : month) + type + ((day < 10) ? '0' + day : day);
  }

}