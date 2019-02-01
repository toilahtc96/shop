package stackjava.com.demojsf.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
@URLMapping(id = "homeClient", pattern = "/dhh/shop", viewId = "/index2.xhtml")
public class HomeController implements Serializable {

}
