package pro.sky.socksapp.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.socksapp.Model.Socks;
import pro.sky.socksapp.Service.SocksService;

@RestController
@RequestMapping("api/socks")
public class SocksController {
//    private final SocksService socksService;
//
//    public SocksController(SocksService socksService) {
//        this.socksService = socksService;
//    }
//
//    @PostMapping
//    @Operation(
//            summary = "Приход товара на склад",
//            description = "Регистрация прихода товара (носков) на склад с указанием характеристик"
//    )
//    @ApiResponses(value = {
//            @ApiResponse(
//                    responseCode = "200",
//                    description = "Удалось добавить приход"),
//            @ApiResponse(
//                    responseCode = "400",
//                    description = "Параметры запроса отсутствуют или имеют некорректный формат"),
//            @ApiResponse(
//                    responseCode = "500",
//                    description = "Произошла ошибка, не зависящая от вызывающей стороны")
//
//    })
//    public ResponseEntity<Socks> createSocks(@RequestBody Socks socks, @RequestParam long quantity) {
//        Socks createdSocks = socksService.addSocks(socks, quantity);
//        return ResponseEntity.ok(createdSocks);
//    }
//
//    @PutMapping
//    @Operation(
//            summary = "Отпуск товара склада",
//            description = "Продажа товара (носков), изменение остатков на складе"
//    )
//    @Parameters(value = {
//            @Parameter(name = "quantity", example = "1")
//    })
//    @ApiResponses(value = {
//            @ApiResponse(
//                    responseCode = "200",
//                    description = "Удалось произвести отпуск носков со склада"),
//            @ApiResponse(
//                    responseCode = "400",
//                    description = "Товара нет на складе в нужном количестве или параметры запроса имеют некорректный формат"),
//            @ApiResponse(
//                    responseCode = "500",
//                    description = "Произошла ошибка, не зависящая от вызывающей стороны")
//    })
//    public ResponseEntity<Socks> editSocks(@RequestBody Socks socks, @RequestParam long quantity) {
//        Socks socks1 = socksService.editSocks(socks, quantity);
//        if (socks1 == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(socks1);
//    }
//
//    @GetMapping
//    @Operation(
//            summary = "Проверка остатков товара на складе",
//            description = "Возвращает общее количество носков на складе, соответствующих переданным в параметрах критериям запроса"
//    )
//    @Parameters(
//            value = {
//                    @Parameter(
//                            name = "cotton min", example = "0"
//                    ),
//                    @Parameter(
//                            name = "cotton max", example = "100"
//                    )
//            }
//    )
//    @ApiResponses(value = {
//            @ApiResponse(
//                    responseCode = "200",
//                    description = "Запрос выполнен"),
//            @ApiResponse(
//                    responseCode = "400",
//                    description = "Параметры запроса отсутствуют или имеют некорректный формат"),
//            @ApiResponse(
//                    responseCode = "500",
//                    description = "Произошла ошибка, не зависящая от вызывающей стороны")
//    })
//    public ResponseEntity<Long> getSocksNumByParam(@RequestParam Socks.Color color, @RequestParam Socks.Size size, @RequestParam int cottonMin, @RequestParam int cottonMax) {
//        long count = socksService.getSocksByParameters(color, size, cottonMin, cottonMax);
//        return ResponseEntity.ok(count);
//    }
//
//    @DeleteMapping
//    @Operation(
//            summary = "Списание брака",
//            description = "Фиксирование списания бракованных носков"
//    )
//    @Parameters(value = {
//            @Parameter(name = "quantity", example = "1")
//    })
//    @ApiResponses(value = {
//            @ApiResponse(
//                    responseCode = "200",
//                    description = "Товар списан со склада"),
//            @ApiResponse(
//                    responseCode = "400",
//                    description = "Параметры запроса отсутствуют или имеют некорректный формат"),
//            @ApiResponse(
//                    responseCode = "500",
//                    description = "Произошла ошибка, не зависящая от вызывающей стороны")
//    })
//    public ResponseEntity<Void> deleteSocks(@RequestBody Socks socks, @RequestParam long quantity) {
//        if (socksService.deleteSocks(socks, quantity)) {
//            return ResponseEntity.ok().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
}
