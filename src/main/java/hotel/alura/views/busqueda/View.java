package hotel.alura.views.busqueda;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.List;

import javax.persistence.NoResultException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import hotel.alura.App;
import hotel.alura.controller.HuespedController;
import hotel.alura.controller.ReservaController;
import hotel.alura.modelo.Huesped;
import hotel.alura.modelo.Reserva;
import hotel.alura.modelo.RowDataProvider;
import hotel.alura.views.Comunicador;
import hotel.alura.views.MenuUsuario;
import hotel.alura.views.busqueda.components.GuestsTable;
import hotel.alura.views.busqueda.components.ReservationsTable;
import hotel.alura.views.resources.Image;

@SuppressWarnings("serial")
public class View extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private GuestsTable tbHuespedes;
	private ReservationsTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHuesped;
	private JLabel labelAtras;
	private JLabel labelExit;
	private JTabbedPane tpTablas;
	int xMouse, yMouse;

	private ReservaController reservationController = App.getReservaController();
	private HuespedController guestController = App.getHuespedController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public View() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Image.LUPA2_URL));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		txtBuscar.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {

			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {

			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				String txt = View.this.txtBuscar.getText();
				if(txt != null && !txt.isBlank()) return;

				if(View.this.reservaEsLaPestañaActiva()) {
						View.this.modelo.setRowCount(0);
						cargarReservas();
				} else {
						View.this.modeloHuesped.setRowCount(0);
						cargarHuespedes(guestController.listar());
				}

			}

			
		});
		
		
		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(331, 62, 280, 42);
		contentPane.add(lblNewLabel_4);
		
		tpTablas = new JTabbedPane(JTabbedPane.TOP);
		tpTablas.setBackground(new Color(12, 138, 199));
		tpTablas.setFont(new Font("Roboto", Font.PLAIN, 16));
		tpTablas.setBounds(20, 169, 865, 328);
		contentPane.add(tpTablas);
		
		tbReservas = new ReservationsTable();
		modelo = (DefaultTableModel) tbReservas.getModel();
		cargarReservas();
		JScrollPane scroll_table = new JScrollPane(tbReservas);
		tpTablas.addTab(Reserva.TITULO, Image.RESERVATIONS, scroll_table, null);
		scroll_table.setVisible(true);
		
		tbHuespedes = new GuestsTable();
		modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
		cargarHuespedes(guestController.listar());
		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
		tpTablas.addTab(Huesped.TITULO, Image.GUESTS, scroll_tableHuespedes, null);
		scroll_tableHuespedes.setVisible(true);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(Image.LOGO_100PX);
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);
		
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
				
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
					}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
				 btnexit.setBackground(Color.white);
				 labelExit.setForeground(Color.black);
				}
			});
			btnexit.setLayout(null);
			btnexit.setBackground(Color.WHITE);
			btnexit.setBounds(857, 0, 53, 36);
			header.add(btnexit);
			
			labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);
		
		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(View.this.obtenerTituloDeLaPestañaActiva() == Reserva.TITULO) {
					try {//Prevenir el procesamiento de un valor invalido
						Long reservaId = Long.parseLong(View.this.txtBuscar.getText());
						try {//Informar busqueda fallida
							Reserva reserva = View.this.reservationController.findBy(reservaId);
							View.this.modelo.setRowCount(0);
							View.this.cargarReserva(reserva);
						} catch(NoResultException ex) {
							Comunicador.informarReservaNoEncontrada(View.this);
						}
					} catch(NumberFormatException ex) {
						Comunicador.informarNumeroInvalido(View.this);
					}
				} else {
					String apellido = View.this.txtBuscar.getText();
					List<Huesped> huespedes = guestController.buscarPorApellido(apellido);
					View.this.modeloHuesped.setRowCount(0);
					View.this.cargarHuespedes(huespedes);
				}
			}
		});
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);
		
		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JPanel btnEditar = new JPanel();
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent args) {
				App.iniciarTransaccion();
				if(View.this.reservaEsLaPestañaActiva()) {
					View.this.reservationController.updateFrom(tbReservas.getDataFromSelectedRow());
				} else {
					View.this.guestController.updateFrom(tbHuespedes.getDataFromSelectedRow());
				}
				App.confirmarTransaccion();
				Comunicador.informarModificacionExitosa(View.this);
			}
		});
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);
		
		JPanel btnEliminar = new JPanel();
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);

		btnEliminar.addMouseListener(new MouseAdapter() {//All Good
			@Override
			public void mouseClicked(MouseEvent e) {
				App.iniciarTransaccion();

				Reserva reservation = null;
				Huesped guest = null;

				if(View.this.reservaEsLaPestañaActiva()) {
					reservation = View.this.reservationController.findIn(tbReservas);
					guest = View.this.guestController.findBy(reservation);
				} else {
					guest = View.this.guestController.findIn(tbHuespedes);
					reservation = guest.getReserva();
				}

				guest.setReserva(null);//Deshasociar la reserva del huesped

				//Eliminar de la base de datos la reserva y el huesped
				View.this.reservationController.remover(reservation);
				View.this.guestController.remover(guest);

				//Actualizar la interfaz de la tabla
				View.this.modelo.setRowCount(0);
				View.this.modeloHuesped.setRowCount(0);
				View.this.cargarHuespedes();
				View.this.cargarReservas();

				App.confirmarTransaccion();

				//Informar de la eliminación del registro
				Comunicador.informarEliminacionExistosa(View.this);
			}
		});
		
		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);
	}
	
//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}
	
	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
		int x = evt.getXOnScreen();
	  int y = evt.getYOnScreen();
	  this.setLocation(x - xMouse, y - yMouse);
	}

	private void insertRow(DefaultTableModel model, RowDataProvider data) {
		model.addRow(data.toArray());
	}
	
	private void insertRows(DefaultTableModel model, List<RowDataProvider> dataList) {
		dataList.forEach(data -> {
			insertRow(model, data);
		});
	}
	
	private void cargarReserva(Reserva reserva) {
		insertRow(modelo, reserva);
	}
	
	/*private void cargarHuesped(Huesped huesped) {
		insertRow(modeloHuesped, huesped);
	}*/
	
	private void cargarReservas(List<Reserva> reservas) {
		insertRows(modelo, RowDataProvider.from(reservas));
	}
	
	private void cargarHuespedes(List<Huesped> huespedes) {
		insertRows(modeloHuesped, RowDataProvider.from(huespedes));
	}

	private void cargarReservas() {
		cargarReservas(reservationController.listar());
	}

	private void cargarHuespedes() {
		cargarHuespedes(guestController.listar());
	}
	
	private String obtenerTituloDeLaPestañaActiva() {
		return this.tpTablas.getTitleAt(this.tpTablas.getSelectedIndex());
	}

	private boolean reservaEsLaPestañaActiva() {
		return this.obtenerTituloDeLaPestañaActiva() == Reserva.TITULO;
	}

}
