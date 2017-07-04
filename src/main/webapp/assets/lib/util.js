/**
  * 用于格式化json对象到字符串的参数定义
  */
var m = {
    '\b': '\\b',
    '\t': '\\t',
    '\n': '\\n',
    '\f': '\\f',
    '\r': '\\r',
    '"': '\\"',
    '\\': '\\\\'
};
var s = {
    'boolean': function(x) {
        return String(x);
    },
    number: function(x) {
        return isFinite(x) ? String(x) : 'null';
    },
    string: function(x) {
        if (/["\\\x00-\x1f"]/.test(x)) {
            x = x.replace(/(["\x00-\x1f\\"])/g,
            function(a, b) {
                var c = m[b];
                if (c) {
                    return c;
                }
                c = b.charCodeAt();
                return '\\u00' + Math.floor(c / 16).toString(16) + (c % 16).toString(16);
            });
        }
        return '"' + x + '"';
    },
    object: function(x) {
        if (x) {
            var a = [],
            b,
            f,
            i,
            l,
            v;
            if (x instanceof Array) {
                a[0] = '[';
                l = x.length;
                for (i = 0; i < l; i += 1) {
                    v = x[i];
                    f = s[typeof v];
                    if (f) {
                        v = f(v);
                        if (typeof v == 'string') {
                            if (b) {
                                a[a.length] = ',';
                            }
                            a[a.length] = v;
                            b = true;
                        }
                    }
                }
                a[a.length] = ']';
            } else if (x instanceof Object) {
                a[0] = '{';
                for (i in x) {
                    v = x[i];
                    f = s[typeof v];
                    if (f) {
                        v = f(v);
                        if (typeof v == 'string') {
                            if (b) {
                                a[a.length] = ',';
                            }
                            a.push(s.string(i), ':', v);
                            b = true;
                        }
                    }
                }
                a[a.length] = '}';
            } else {
                return;
            }
            return a.join('');
        }
        return 'null';
    }
};
 
/**
     * 将指定的json对象解析成字符串
     *
     * @param  v   将要被解析的json对象
     *
     * @return json解析后的字符串
     */
$.jsonToString = function(jsonObject) {
    var f = s[typeof jsonObject];
    if (f) {
        jsonObject = f(jsonObject);
        if (typeof jsonObject == 'string') {
            return jsonObject;
        }
    }
    return null;
};
 
/**
  * 格式化表单内容为json对象（通常用于获取一个form表单的值）
  *
  * @param   notEmptyField   序列化的结果中是否包含值为空的域
  *
  * @return  当前选择器所选定的值域标签对应的值json对象
  */
$.fn.serializeToJson = function(notEmptyField) {
    var obj = {};
    $.each(this.serializeArray(),
    function(i, o) {
        var n = o.name,
        v = $.trim(o.value);
        if (! (notEmptyField && "" == v)) {
            obj[n] = (obj[n] === undefined) ? v: $.isArray(obj[n]) ? obj[n].concat(v) : [obj[n], v];
        }
    });
var $radio = $('input[type=radio],input[type=checkbox]',this);
                $.each($radio, function(){
                    if(!obj.hasOwnProperty(this.name)){
                        obj[this.name] = '';
                    }
                });
    return obj;
};
 
/**
  * 将json中的值填充到页面中（可以按field指定的属性进行赋值）
  *
  * @param   options json对象，指定参数，具体参数有：
  *
  * @param   options.data    用于填充的json数据对象
  * @param   options.utl 加载初始化数据的url(url对应请求返还的数据必须是json对象，key就是页面标签的options.field属性的值)
  * 注意，当data和url同时指定时，data优先使用
  * @param   options.field   填充数据data中的key对应标签的那个属性值，用于定位input域进行赋值，默认为
  *    不指定则为name($('name=key').val(value))，否则为field指定的标签属性
  * @param   options.type    填充数据的方式，text：将数据填充到text域中，否则填充到value域中
  */
$.fn.serializeToForm = function(options) {
    if (!options || (!options.data && !options.url)) return false;
    //如果按照标签的name属性给input域赋值，则使用easyui自带的赋值功能，否则自实现赋值
    if ((!options.field || 'name' == options.field) && (!options.type || "text" != options.type)) {
        //如果指定了数据，则优先使用给定的数据赋值，否则通过url加载
        if (options.data) {
            $(this).form('load', options.data);
        } else {
            $(this).form('load', options.url);
        }
        return true;
    }
    //自实现赋值,如果指定了数据，则优先使用给定的数据赋值，否则通过url加载
    if (!options.field) options.field = "name";
    if (options.data) {
        initFormByData(this, options);
    } else {
        var formObj = this;
        $.ydSubmit({
            url: options.url,
            paramType: 'json',
            callback: function(data) {
                options.data = data;
                initFormByData(formObj, options);
            }
        });
    }
    //根据给定的json数据对象对form表单进行初始
    function initFormByData(formObj, options) {
        for (var key in options.data) {
            var inputObj = formObj.find("[" + options.field + "='" + key + "']");
            if (inputObj && inputObj.size() > 0 && options.data[key] && "null" != options.data[key]) {
                if (options.type && 'text' == options.type) {
                    inputObj.text(options.data[key]);
                } else {
                    inputObj.val(options.data[key]);
                }
            }
        }
    }
};