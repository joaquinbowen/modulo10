package com.krakedev.veterinaria.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.krakedev.veterinaria.entity.Mascota;
import com.krakedev.veterinaria.repository.MascotaRepository;
import com.krakedev.veterinaria.service.MascotaService;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Service
@RequiredArgsConstructor
public class MascotaServiceImpl implements MascotaService {

    private MascotaRepository mascotaRepository;

    @Override
    public Mascota registrarMascota(Mascota mascota) {
        Mascota nuevaMascota = mascotaRepository.save(mascota);
        return nuevaMascota;
    }

    @Override
    public List<Mascota> listarMascotas() {
        return mascotaRepository.findAll();
    }

    @Override
    public Optional<Mascota> buscarPorNombre(String nombre) {
        Optional<Mascota> mascota = mascotaRepository.findByNombre(nombre);
        return mascota;
    }

    @Override
    public Optional<Mascota> buscarPorId(Long id) {
        return mascotaRepository.findByIdMascota(id);
    }

    @Override
    @SneakyThrows
    public Mascota actualizarMascota(Long id, Mascota mascota) {
        Mascota mascotaExistente = mascotaRepository.findByIdMascota(id)
                .orElseThrow(() -> new Exception("Mascota con ID " + id + " no encontrada"));

        mascotaExistente.setNombre(mascota.getNombre());
        mascotaExistente.setEspecie(mascota.getEspecie());
        mascotaExistente.setEdad(mascota.getEdad());
        mascotaExistente.setNombreDueno(mascota.getNombreDueno());
        mascotaExistente.setFechaRegistro(mascota.getFechaRegistro());

        Mascota mascotaActualizada = mascotaRepository.save(mascotaExistente);
        return mascotaActualizada;
    }

    @Override
    @SneakyThrows
    public void eliminarMascota(Long id) {
        mascotaRepository.findByIdMascota(id)
                .orElseThrow(() -> new Exception("Mascota con ID " + id + " no encontrada"));

        mascotaRepository.deleteById(id);
    }
}
