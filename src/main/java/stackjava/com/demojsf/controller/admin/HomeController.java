package stackjava.com.demojsf.controller.admin;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
@URLMapping(id = "homeAdminController", pattern = "/dhh/shop", viewId = "/trangnaylanhumotvidumoi.xhtml")
public class HomeController implements Serializable {

}
