package stackjava.com.demojsf.form;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

@ManagedBean
@SessionScoped
public class CreateCategoryForm implements Serializable {
	String catName;
	String catAlias;
	String catSeoText;
	Part image;
	String catDes;
	String catType;
	int catActive;
	int catParent;
	int catChild;
	int catHot;
	int catNew;
	int catRoot;
	String catSlug;
	Date catCreat;
	Date catUpdate;
	// phai nho get set

	HashMap<Integer, String> listCate;

	public HashMap<Integer, String> getListCate() {
		return listCate;
	}

	public void setListCate(HashMap<Integer, String> listCate) {
		this.listCate = listCate;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getCatAlias() {
		return catAlias;
	}

	public void setCatAlias(String catAlias) {
		this.catAlias = catAlias;
	}

	public String getCatSeoText() {
		return catSeoText;
	}

	public void setCatSeoText(String catSeoText) {
		this.catSeoText = catSeoText;
	}

	

	public Part getImage() {
		return image;
	}

	public void setImage(Part image) {
		this.image = image;
	}

	public String getCatDes() {
		return catDes;
	}

	public void setCatDes(String catDes) {
		this.catDes = catDes;
	}

	public String getCatType() {
		return catType;
	}

	public void setCatType(String catType) {
		this.catType = catType;
	}

	public int getCatActive() {
		return catActive;
	}

	public void setCatActive(int catActive) {
		this.catActive = catActive;
	}

	public int getCatParent() {
		return catParent;
	}

	public void setCatParent(int catParent) {
		this.catParent = catParent;
	}

	public int getCatChild() {
		return catChild;
	}

	public void setCatChild(int catChild) {
		this.catChild = catChild;
	}

	public int getCatHot() {
		return catHot;
	}

	public void setCatHot(int catHot) {
		this.catHot = catHot;
	}

	public int getCatNew() {
		return catNew;
	}

	public void setCatNew(int catNew) {
		this.catNew = catNew;
	}

	public int getCatRoot() {
		return catRoot;
	}

	public void setCatRoot(int catRoot) {
		this.catRoot = catRoot;
	}

	public String getCatSlug() {
		return catSlug;
	}

	public void setCatSlug(String catSlug) {
		this.catSlug = catSlug;
	}

	public Date getCatCreat() {
		return catCreat;
	}

	public void setCatCreat(Date catCreat) {
		this.catCreat = catCreat;
	}

	public Date getCatUpdate() {
		return catUpdate;
	}

	public void setCatUpdate(Date catUpdate) {
		this.catUpdate = catUpdate;
	}

}
