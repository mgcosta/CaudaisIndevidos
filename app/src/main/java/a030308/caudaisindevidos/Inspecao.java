package a030308.caudaisindevidos;

/**
 * Created by a030308 on 03/01/2018.
 */

public class Inspecao {
    protected int id, createdBy;
    protected String rua, Porta, localidade, referencia, cartasig, contato, instalador, bombagem, ligado, tamponamento, material, crl, localizacao, diametro, profundidade, estado, anomalia, foto, fecho, obs ;

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return this.id;
    }

    public void setRua(String rua)
    {
        this.rua = rua;
    }

    public String getRua()
    {
        return this.rua;
    }

    public void setPorta(String Porta)
    {
        this.Porta = Porta;
    }

    public String getPorta()
    {
        return this.Porta;
    }

    public void setLocalidade(String localidade)
    {
        this.localidade = localidade;
    }

    public String getLocalidade()
    {
        return this.localidade;
    }

    public void setReferencia(String referencia)
    {
        this.referencia = referencia;
    }

    public String getReferencia()
    {
        return this.referencia;
    }

    public void setCartasig(String cartasig)
    {
        this.cartasig = cartasig;
    }

    public String getCartasig()
    {
        return this.cartasig;
    }

    public void setContato(String contato)
    {
        this.contato = contato;
    }

    public String getContato()
    {
        return this.contato;
    }

    public void setCreatedBy(Integer createdBy)
    {
        this.createdBy = createdBy;
    }

    public Integer getUserId()
    {
        return this.createdBy;
    }


    public void setFecho(String fecho)
    {
        this.fecho = fecho;
    }

    public String getFecho()
    {
        return this.fecho;
    }

    public void setFoto(String foto)
    {
        this.foto = foto;
    }

    public String getFoto()
    {
        return this.foto;
    }

    public void setObs(String obs)
    {
        this.obs = obs;
    }

    public String getObs()
    {
        return this.obs;
    }

    public void setAnomalia(String anomalia)
    {
        this.anomalia = anomalia;
    }

    public String getAnomalia()
    {
        return this.anomalia;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
    }

    public String getEstado()
    {
        return this.estado;
    }

    public void setProfundidade(String profundidade)
    {
        this.profundidade = profundidade;
    }

    public String getProfundidade()
    {
        return this.profundidade;
    }

    public void setDiametro(String diametro)
    {
        this.diametro = diametro;
    }

    public String getDiametro()
    {
        return this.diametro;
    }

    public void setLocalizacao(String localizacao)
    {
        this.localizacao = localizacao;
    }

    public String getLocalizacao()
    {
        return this.localizacao;
    }

    public void setInstalador(String instalador)
    {
        this.instalador = instalador;
    }

    public String getInstalador()
    {
        return this.instalador;
    }

    public void setBombagem(String bombagem)
    {
        this.bombagem = bombagem;
    }

    public String getBombagem()
    {
        return this.bombagem;
    }

    public void setLigado(String ligado)
    {
        this.ligado = ligado;
    }

    public String getLigado()
    {
        return this.ligado;
    }

    public void setTamponamento(String tamponamento)
    {
        this.tamponamento = tamponamento;
    }

    public String getTamponamento()
    {
        return this.tamponamento;
    }

    public void setMaterial(String material)
    {
        this.material = material;
    }

    public String getMaterial()
    {
        return this.material;
    }

    public void setCrl(String crl)
    {
        this.crl = crl;
    }

    public String getCrl()
    {
        return this.crl;
    }

}
